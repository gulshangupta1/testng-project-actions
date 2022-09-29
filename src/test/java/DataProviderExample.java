import org.testng.annotations.DataProvider;

public class DataProviderExample {

    @DataProvider(name = "additionData")
    private Object[][] additionDataMethod(){
        return new Object[][]{{1,2,3},
                {2,3,5},
                {4,5,9}};
    }

}