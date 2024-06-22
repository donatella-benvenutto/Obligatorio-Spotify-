package uy.edu.um.adt.linkedlist;

import uy.edu.um.adt.queue.EmptyQueueException;
import uy.edu.um.adt.queue.MyQueue;
import uy.edu.um.adt.stack.EmptyStackException;
import uy.edu.um.adt.stack.MyStack;

import java.util.Comparator;
import java.util.List;

public class MyLinkedListImpl<T> implements MyList<T>, MyQueue<T>, MyStack<T>{

    private Node<T> first;

    private Node<T> last;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(T value) {
        addToTheEnd(value);
    }

    private void addToBeginning(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al comienzo

                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    private void addToTheEnd(T value) {
        if (value != null) {

            Node<T> elementToAdd = new Node<>(value);

            if (this.first == null) { // si la lista es vacia

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else { // en caso de no ser vacia se agrega al final

                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }

        } else {
            // si el elemento es vacio se ignora
        }
    }

    @Override
    public T get(int position) {
        T valueToReturn = null;
        int tempPosition = 0;
        Node<T> temp = this.first;

        // Se busca el nodo que corresponde con la posicion
        while (temp != null && tempPosition != position) {

            temp = temp.getNext();
            tempPosition++;

        }

        // si se encontro la posicion se retorna el valor
        // en caso que se haya llegado al final y no se llego a la posicion se retorna null
        if (temp == null){
            return null;
        } else {
            return temp.getValue();
        }

    }

    // Operaciones particulares a Queue

    public void enqueue(T value) {
        addToBeginning(value);
    }

    public T dequeue() throws EmptyQueueException {
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }

        return removeLast();
    }
    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> temp = this.first;

        while (temp != null && !temp.getValue().equals(value)) {

            temp = temp.getNext();

        }

        if (temp != null) { // Si no se llego al final de la lista, se encontro el valor

            contains = true;

        }

        return contains;
    }

    @Override
    public void remove(T value) {
        Node<T> beforeSearchValue = null;
        Node<T> searchValue = this.first;

        // Busco el elemento a eliminar teniendo en cuenta mantener una referencia al elemento anterior
        while (searchValue != null && !searchValue.getValue().equals(value)) {

            beforeSearchValue = searchValue;
            searchValue = searchValue.getNext();

        }

        if (searchValue != null) { // si encontre el elemento a eliminar

            // Verifico si es el primer valor (caso borde) y no es el ultimo
            if (searchValue == this.first && searchValue != this.last) {

                Node<T> temp = this.first;
                this.first = this.first.getNext(); // salteo el primero

                temp.setNext(null); // quito referencia del elemento eliminado al siguiente.

                // Verifico si es el primer valor (caso borde) y no el primero
            } else if (searchValue == this.last && searchValue != this.first) {

                beforeSearchValue.setNext(null);
                this.last = beforeSearchValue;

                // Si es el primer valor y el ultimo (lista de un solo valor)
            } else if (searchValue == this.last && searchValue == this.first) {

                this.first = null;
                this.last = null;

            } else { // resto de los casos

                beforeSearchValue.setNext(searchValue.getNext());
                searchValue.setNext(null);

            }

        } else {

            // Si no es encuentra el valor a eliminar no se realiza nada

        }

    }

    private T removeLast() { // esta operación remueve el último elemento y retorna el elemento eliminado
        T valueToRemove = null;

        if (this.last != null) {
            valueToRemove = this.last.getValue();

            remove(valueToRemove);
        }

        return valueToRemove;
    }

    @Override
    public int size() {
        int size = 0;

        Node<T> temp = this.first;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }

    public void addToPosition(T value, int position) {
        if (value != null) {
            Node<T> elementToAdd = new Node<>(value);
            Node<T> temp = this.first;
            int tempPosition = 0;

            if (position == 0) {
                addToBeginning(value);
            } else if (position == size()) {
                addToTheEnd(value);
            } else if (position > 0 && position < size()) {
                while (temp != null && tempPosition != position - 1) {
                    temp = temp.getNext();
                    tempPosition++;
                }
                elementToAdd.setNext(temp.getNext());
                temp.setNext(elementToAdd);
            }
        }
    }
    // Operaciones particulares a Stack

    public void push(T value) {
        addToTheEnd(value);
    }

    public T pop() throws EmptyStackException {
        if (this.last == null) { // si la pila esta vacia

            throw new EmptyStackException();
        }

        return removeLast();
    }

    public T peek() {
        T valueToReturn = null;

        if (this.last != null) {
            valueToReturn = this.last.getValue();
        }

        return valueToReturn;
    }

    public boolean isEmpty() {
        return (this.first == null && this.last==null);
    }

    public String parseMylisttoString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = this.first;
        while (temp != null) {
            sb.append(temp.getValue().toString());
            temp = temp.getNext();
        }
        return sb.toString();
    }
    public MyList<T> parseFromJavaList(List<T> list) {
        MyList<T> myList = new MyLinkedListImpl<>();
        for (T element : list) {
            myList.add(element);
        }
        return myList;
    }
    @Override
    public Node<T> getlast(){
        return this.last;
    }
    @Override
    public void set(int position, T value) {
        if (position < 0 || position >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node<T> temp = this.first;
        int currentPosition = 0;
        while (temp != null && currentPosition != position) {
            temp = temp.getNext();
            currentPosition++;
        }
        if (temp != null) {
            temp.setValue(value);
        }
    }
    public void addInOrder(T track, Object o) {
        Node<T> temp = this.first;
        Node<T> elementToAdd = new Node<>(track);
        if (temp == null) {
            this.first = elementToAdd;
            this.last = elementToAdd;
        } else {
            while (temp != null) {
                if (o instanceof Comparator) {
                    if (((Comparator<T>) o).compare(track, temp.getValue()) > 0) {
                        if (temp == this.first) {
                            elementToAdd.setNext(this.first);
                            this.first = elementToAdd;
                            break;
                        } else {
                            Node<T> temp2 = this.first;
                            while (temp2.getNext() != temp) {
                                temp2 = temp2.getNext();
                            }
                            temp2.setNext(elementToAdd);
                            elementToAdd.setNext(temp);
                            break;
                        }
                    } else if (temp == this.last) {
                        this.last.setNext(elementToAdd);
                        this.last = elementToAdd;
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("El segundo parametro debe ser un Comparator");
                }
                temp = temp.getNext();
            }
        }
    }
}