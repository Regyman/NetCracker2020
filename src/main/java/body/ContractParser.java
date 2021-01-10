package body;

import CSV.CSVParser;
import CSV.CSVReader;
import DI.Injector;
import Validation.Result;
import Validation.Validator;

import javax.inject.Inject;


public class ContractParser {

    @Inject
    private CSVParser parser;
    @Inject
    private CSVReader reader;
    @Inject
    public Validator<BaseContract> validator;

    public ContractParser(){
        Injector.inject(this);
    }

    /**
     * Создает новый репозиторий с данными из csv файла
     * @return Repository из файла
     */
    public Repository parse() {
        Repository contractRepository = new Repository();

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
            BaseContract contract = parser.from(contractSource, parseClass(contractType));
            int errorCount = 0;
            if(validator!=null)
                for(Result result: validator.validate(contract) ){
                    if (!result.isValid()) {
                        errorCount++;
                        System.err.println(result.getMessage());
                    }
                }
            if(errorCount==0)
                contractRepository.add(parser.from(contractSource, parseClass(contractType)));
        }

        return contractRepository;
    }

    private Class<? extends BaseContract> parseClass(String s) {
        if ("internet".equals(s.toLowerCase())) {
            return InternetContract.class;
        } else if ("mobile".equals(s.toLowerCase())) {
            return MobileContract.class;
        } else if ("tv".equals(s.toLowerCase())) {
            return TVContract.class;
        }
        return null;
    }

    private static String join(Object[] objects, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            sb.append(objects[i]);
            if (i != objects.length - 1)
                sb.append(separator);
        }

        return sb.toString();
    }
}
