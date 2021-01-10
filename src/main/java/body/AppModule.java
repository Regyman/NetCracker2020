package body;

import CSV.CSVParser;
import CSV.CSVReader;
import DI.Provides;
import Sorter.Isorter;
import Sorter.QuickSorter;
import Validation.Condition;
import Validation.Validator;
import Validation.ValidatorBuilder;

import javax.inject.Singleton;
import java.io.File;
import java.net.URISyntaxException;

public class AppModule {
    @Provides
    @Singleton
    public File file(){
        try {
            return CSVReader.getFileFromResource("tableContents.csv");
        } catch (URISyntaxException e){
            return null;
        }
    }
    @Provides
    @Singleton
    public Validator<BaseContract> validator(){
        ValidatorBuilder<BaseContract> builder = new ValidatorBuilder<>();

        builder.add(new Condition<>(0, BaseContract::getID, ((expected, actual) -> actual%2==expected)));
        builder.add(new Condition<>("lera",
                contract -> contract.getOwner().getFullName()
        ));


        return builder.build();
    }

    @Provides
    @Singleton
    public CSVReader reader(File file){
        return new CSVReader(file);
    }

    @Provides
    @Singleton
    public CSVParser parser(){
        return new CSVParser();
    }

    @Provides
    @Singleton
    public Isorter sorter(){
        return new QuickSorter();
    }
}
