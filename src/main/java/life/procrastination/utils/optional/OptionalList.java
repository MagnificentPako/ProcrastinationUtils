package life.procrastination.utils.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalList<T> {

    private List<T> optionalList;

    public OptionalList() {
        this.optionalList = new ArrayList();
    }

    public Optional<T> get(int position) {
        if(this.optionalList.get(position) != null)
            return Optional.of(this.optionalList.get(position));
        return Optional.empty();
    }

    public void set(int position, T elem) {
        this.optionalList.set(position, elem);
    }

    public boolean add(T elem) {
        return this.optionalList.add(elem);
    }

    public boolean contains(T elem) {
        return this.optionalList.contains(elem);
    }

    public static <T> OptionalList<T> of(List<T> list) {
        OptionalList<T> theList = new OptionalList();
        list.forEach(elem -> theList.add(elem));
        return theList;
    }

    public List<T> raw() {
        return optionalList;
    }

}
