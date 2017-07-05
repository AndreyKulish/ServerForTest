package Servlet;

import DBConfig.CRUDForURL;
import DBConfig.MySQLCRUDForURLImpl;
import DBConfig.TableEntity;
import Model.InterfaceValidate;
import Model.Validate;

/**
 * Created by Andrey on 04.07.2017.
 */
public class Work implements Runnable {

    public TableEntity tableEntity;
    private boolean flag;
    private CRUDForURL crudForURL = new MySQLCRUDForURLImpl();
    InterfaceValidate interfaceValidate;

    public Work(TableEntity tableEntity){
        this.tableEntity = tableEntity;
        interfaceValidate =  new Validate(tableEntity.getURL(), tableEntity);
    }

    private static int i;
    @Override
    public void run() {
       while (true){

          if(Thread.currentThread().getName().equals("KILL_MY_PLZ")||tableEntity.getON_OFF().equals("ERROR")){
               break;
          }

           while(tableEntity.getON_OFF().equals("OFF")){

               try{
                   Thread.sleep(1000);
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }
           }
           try {

               tableEntity.setCODE(interfaceValidate.codeResponse());
               tableEntity.setSIZE(interfaceValidate.contentLenght());
               tableEntity.setCONNECT_TIME((int)(interfaceValidate.timeToConnection()));
               if(interfaceValidate.codeResponse() == 200 &&(
                       interfaceValidate.contentLenght() < tableEntity.getRESPONSE_SIZE_MAX()&&
                       interfaceValidate.contentLenght() > tableEntity.getRESPONSE_SIZE_MIN())&&
                       interfaceValidate.timeToConnection() < tableEntity.getTIME_RESPONSE_OK()){
                    tableEntity.setSTATUS("OK");
               }else
                   if(interfaceValidate.codeResponse() == 200 ||(
                           interfaceValidate.contentLenght() < tableEntity.getRESPONSE_SIZE_MAX()||
                                   interfaceValidate.contentLenght() > tableEntity.getRESPONSE_SIZE_MIN())||
                           interfaceValidate.timeToConnection() < tableEntity.getTIME_RESPONSE_OK()){
                       tableEntity.setSTATUS("WARNING");
                   }else{
                       tableEntity.setSTATUS("CRITICAL");
                   }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }


               try{

               Thread.sleep(1000);
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
       }
    }
}
