package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            String inp = InputUtil.input("Pilih");
            if (inp.equals("1")) {
                addTodoList();
            } else if (inp.equals("2")) {
                removeTodoList();
            } else if (inp.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dapat dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        String todo = InputUtil.input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        String no = InputUtil.input("Nomor yang dihapus (x jika batal)");
        if (no.equals("x")) {
            //batal
        } else {
           todoListService.removeTodoList(Integer.valueOf(no));
        }
    }
}
