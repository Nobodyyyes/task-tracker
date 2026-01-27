package com.example.demo.mappers;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public interface BaseMapper<M, E> {

    M toModel(E entity);

    E toEntity(M model);

    default List<E> toEntities(List<M> models) {
        return mapEach(models, this::toEntity);
    }

    default List<M> toModels(List<E> entities) {
        return mapEach(entities, this::toModel);
    }

    private <F, T> List<T> mapEach(List<F> from, Function<F, T> withMapper) {

        if (from == null) return Collections.emptyList();

        return from.stream().map(withMapper).toList();
    }
}
