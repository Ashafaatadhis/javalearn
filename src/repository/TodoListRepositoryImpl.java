package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository {
    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull() {
        boolean isFull = true;

        for (Todolist datum : data) {
            if (datum == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull() {
        if (isFull()) {
            Todolist[] temp = data;
            data = new Todolist[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }

        }
    }

    @Override
    public void add(Todolist todolist) {
        resizeIfFull();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (number >= data.length || number < 1 || data[(number - 1)] == null) {
            return false;
        }

        for (int i = (number - 1); i < data.length; i++) {
            if (data[i] == null) {
                break;
            } else {
                data[i] = data[i + 1];
            }
        }

        return true;
    }
}
