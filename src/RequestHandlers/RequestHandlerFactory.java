package RequestHandlers;

public class RequestHandlerFactory {
    public static Requesthandler createHandler(String command) {
        if (command.equalsIgnoreCase("")){
            try {
                Requesthandler handler = (Requesthandler) Index.class.newInstance();
                return handler;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        try{
            Class c = Class.forName("RequestHandlers."+command);
            Object o = c.newInstance();
            Requesthandler handler = (Requesthandler) o;
            return handler;
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
