package view_builders;

import java.util.List;

interface ListBuilder<T,S> extends Builder<List> {
    List<T> getProduct();
}
