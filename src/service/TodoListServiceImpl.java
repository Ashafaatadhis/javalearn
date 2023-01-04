package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }
    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();
        System.out.println("TODOLIST");
        for(int i = 0; i < model.length; i++ ){
            if(model[i] == null){
                break;
            }
            System.out.println(i+1 + ". " + model[i].getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success){
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        }else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }
}
