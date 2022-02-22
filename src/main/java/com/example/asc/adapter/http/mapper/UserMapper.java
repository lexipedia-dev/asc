package com.example.asc.adapter.http.mapper;

import com.example.asc.adapter.http.dto.entrada.UsuarioDtoEntrada;
import com.example.asc.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "usuarioDtoEntrada.name", target = "nome")
    })
    Usuario getEntityFromDtoEntrada(UsuarioDtoEntrada usuarioDtoEntrada);
}
