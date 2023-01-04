import java.util.Scanner;

public class TodoList {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
        viewShowTodoList();
    }

    public static void showTodoList(){
        System.out.println("TodoList");
        for(int i = 0; i < model.length; i++ ){
            if(model[i] == null){
                break;
            }
            System.out.println(i+1 + ". " + model[i]);
        }
    }

    public static void testShowTodoList(){
        model[0] = "Test1";
        model[1] = "Test2";
        showTodoList();
    }

    public static void viewShowTodoList(){
        while(true){
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            String inp = input("Pilih");
            if(inp.equals("1")){
                viewAddTodoList();
            } else if (inp.equals("2")) {
                viewRemoveTodoList();
            } else if (inp.equals("x")) {
                break;
            }else {
                System.out.println("Pilihan tidak dapat dimengerti");
            }
        }

    }

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        String todo = input("Todo (x jika batal)");
        if(todo.equals("x")){
            // batal
        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Capek");
        addTodoList("oeifjaowef");
        addTodoList("woiiii");
        viewAddTodoList();
        showTodoList();
    }

    public static void testViewShowTodoList(){
        viewShowTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");
        String no = input("Nomor yang dihapus (x jika batal)");
        if(no.equals("x")){
            //batal
        }else{
            if(removeTodoList(Integer.valueOf(no))){
                System.out.println("Berhasil menghapus Todo list");
            }else{
                System.out.println("Gagal menghapus Todo list");
            }
        }
    }

    public static void testViewRemoveTodoList(){

        addTodoList("Capek");
        addTodoList("oeifjaowef");
        addTodoList("woiiii");
        addTodoList("woiiii");
        addTodoList("woiiii");
        addTodoList("woiiii");
        addTodoList("woiiii");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }

    public static boolean removeTodoList(Integer no){
        if(no >= model.length || no < 1 || model[(no-1)] == null){
            return false;
        }

        for(int i = (no-1); i < model.length; i++){
            if(model[i] == null){
                break;
            }else{
                model[i] = model[i+1];
            }
        }

        return true;

    }

    public static void addTodoList(String todo){
        boolean isFull = true;
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        if(isFull){
            String[] temp = model;
            model = new String[model.length*2];
            for(int i =0; i<temp.length; i++){
                model[i] = temp[i];
            }

        }

        for(int i = 0; i < model.length; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }



    public static String input(String info){
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
}
