package body;

import CSV.CSVParser;
import CSV.CSVReader;

import java.io.File;

public class ContractParser {


    private static String join(Object[] objects, String separator) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            builder.append(objects[i]);
            if (i != objects.length - 1)
                builder.append(separator);
        }

        return builder.toString();
    }

    /**
     * Метод, создающий репозиторий с данными из cvs файла
     * @param file csv файл для парсинга
     * @return Repository из файла
     */
    public Repository parse(File file) {
        Repository rep = new Repository();
        CSVReader reader = new CSVReader(file);
        CSVParser parser = new CSVParser();

        for (String line : reader.readLines()) {
            String[] sourceValues = line.split(",");
            for (int i = 0; i < sourceValues.length; i++)
                sourceValues[i] = sourceValues[i].trim();

            String[] extra = sourceValues[sourceValues.length - 1].split(";");
            String temp = sourceValues[5];
            sourceValues[5] = sourceValues[6];
            sourceValues[6] = temp;
            temp = sourceValues[10];
            sourceValues[10] = sourceValues[9];
            sourceValues[9] = temp;
            String contractType = sourceValues[10];
            System.arraycopy(sourceValues, 0, sourceValues, 1, sourceValues.length - 2);
            sourceValues[0] = temp;
            String[] normalValues = new String[sourceValues.length + extra.length - 1];


            System.arraycopy(extra, 0, normalValues, 0, extra.length);
            System.arraycopy(sourceValues, 1, normalValues, extra.length, sourceValues.length - 2);

            String contractSource = join(normalValues, ",");
            rep.add(parser.from(contractSource, parseNeededClass(contractType)));
        }

        return rep;
    }

    /**Метод, считывающий нужный подкласс
     * @param  additional информация о ннужном классе
     * @return  нужный класс или null*/
    private Class<? extends BaseContract> parseNeededClass(String additional) {
        switch (additional.toLowerCase()) {
            case "internet":
                return InternetContract.class;
            case "mobile":
                return MobileContract.class;
            case "tv":
                return TVContract.class;
        }
        return null;
    }
}