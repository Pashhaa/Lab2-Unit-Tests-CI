public class MyLinkedList {
    public int length;
    Unit first;
    Unit last;

    public MyLinkedList() {
        first = null;
        last = null;
        length = 0;
    }

    private static class Unit {
        char element;
        Unit next;
        Unit prev;
        int index;

        private Unit(char element, int index) {
            this.element = element;
            this.index = index;
        }
    }

    public int length() {
        return length;
    }

    public void append(char element) {
        Unit unit = new Unit(element, length);
        if (first == null) {
            first = last = unit;
        } else {
            last.next = unit;
            unit.prev = last;
            last = unit;
        }
        length++;
    }

    public void insert(char element, int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        } else {
            Unit varUnit = first;
            while (varUnit.index != index) {
                varUnit = varUnit.next;
            }
            varUnit.element = element;
        }
    }

    public char delete(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        } else {
            Unit varUnit = first;
            while (varUnit.index != index) {
                varUnit = varUnit.next;
            }
            if (first.index == last.index) {
                first = null;
                last = null;
            } else if (varUnit.index == first.index) {
                first = varUnit.next;
                first.prev = null;
            } else if (varUnit.index == last.index) {
                last = varUnit.prev;
                last.next = null;
            } else {
                varUnit.prev.next = varUnit.next;
                varUnit.next.prev = varUnit.prev;
            }
            length--;
            Unit indexUnit = first;
            int count = 0;
            while (count != length){
                indexUnit.index = count;
                indexUnit = indexUnit.next;
                count++;

            }
            return varUnit.element;
        }
    }


    public void deleteAll (char element){
        Unit varUnit = first;
        while (varUnit != null) {
            if (varUnit.element == element) {
                if (first.index == last.index) {
                    first = null;
                    last = null;
                } else if (varUnit.index == first.index) {
                    first = varUnit.next;
                    first.prev = null;
                } else if (varUnit.index == last.index) {
                    last = varUnit.prev;
                    last.next = null;
                } else {
                    varUnit.prev.next = varUnit.next;
                    varUnit.next.prev = varUnit.prev;
                }
                length--;
                Unit indexUnit = first;
                int count = 0;
                while (count != length){
                    indexUnit.index = count;
                    indexUnit = indexUnit.next;
                    count++;
                }
            }
            varUnit = varUnit.next;
        }
    }
    public char get(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        } else {
            Unit varUnit = first;
            while (varUnit.index != index) {
                varUnit = varUnit.next;
            }
            return varUnit.element;
        }
    }

    public MyLinkedList clone () {
        MyLinkedList twin = new MyLinkedList();
        Unit varUnit = first;
        while (varUnit != null) {
            twin.append(varUnit.element);
            varUnit = varUnit.next;
        }
        return twin;
    }

    public void reverse () {
        Unit varUnitFirst = first;
        Unit varUnitLast = last;
        int count = 0;
        char var;
        while (count != Math.floor(length/2)) {
            var = varUnitFirst.element;
            varUnitFirst.element = varUnitLast.element;
            varUnitLast.element = var;
            count++;
        }
    }

    public int findFirst ( char searchingElement) {
        Unit varUnit = first;
        int index = -1;
        int count = -1;
        while (count != length) {
            if(varUnit.element == searchingElement){
                return varUnit.index;
            }
            varUnit = varUnit.next;
            count ++;
        }
        return index;
    }


    public int findLast ( char searchingElement){
        Unit varUnit = last;
        int index = -1;
        int count = length;
        while (count != 0) {
            if(varUnit.element == searchingElement){
                return varUnit.index;
            }
            varUnit = varUnit.prev;
            count --;
        }
        return index;
    }

    public void clear () {
        Unit varUnit = last;
        while (varUnit.prev != null) {
            varUnit.next = null;
            varUnit = varUnit.prev;
        }
        length = 0;
        first = null;
        last = null;
    }

    public void extend (MyLinkedList newLinkedList){
        while (newLinkedList.length != 0) {
            append(newLinkedList.delete(0));
        }
    }
    public Unit testMethod(){
        return first;
    }
}
