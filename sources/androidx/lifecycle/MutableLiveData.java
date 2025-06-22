package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t4) {
        super(t4);
    }

    public void postValue(T t4) {
        super.postValue(t4);
    }

    public void setValue(T t4) {
        super.setValue(t4);
    }

    public MutableLiveData() {
    }
}
