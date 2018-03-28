package com.frame.db.wr;

public class HandleDataSource {

	private static final String MASTER = "master";  
	  
    private static final String SLAVE = "slave";  
      
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();  
  
    public static void putDataSourceKey(String key) {  
        holder.set(key);  
    }  
  
    public static String getDataSourceKey() {  
        return holder.get();  
    }  
      
    public static void markMaster(){  
        putDataSourceKey(MASTER);  
    }  
      
    public static void markSlave(){  
        putDataSourceKey(SLAVE);  
    }  
}
