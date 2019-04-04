package view_builders;

import java.util.List;

public interface ViewBuilder<T, S> {
    void buildHeader();
    void buildContents();
    T getHeader();
    List<S> getContents();
}
