package spring.tutorial.web.base.service.mapper;

public interface EntityMapper<D, E> {

    D toDTo(E entiry);

    E toEntity(D dto);
}
