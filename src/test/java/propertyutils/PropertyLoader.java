package propertyutils;

import java.util.Properties;

public class PropertyLoader {

 private    static PropertyLoader propertyLoader;

    static Properties properties;


    private  PropertyLoader(){

     properties=PropertyInstance.getPropertyInstance();
    }

          public static PropertyLoader getPropertyLoader(){

        if (propertyLoader==null){
            propertyLoader= new PropertyLoader();
        }


            return  propertyLoader;
    }

     public String getBaseurl(){

        if (properties!=null){
            return properties.getProperty("baseuri");
        }
        else
            throw new RuntimeException("property cannot be retrieved...");
     }

    public String getBasepath(){

        if (properties!=null){
            return properties.getProperty("basepath");
        }
        else
            throw new RuntimeException("property cannot be retrieved...");
    }

     public Properties getProperty(){
        return properties;
     }
}
