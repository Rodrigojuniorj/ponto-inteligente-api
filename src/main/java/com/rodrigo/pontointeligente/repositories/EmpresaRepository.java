package com.rodrigo.pontointeligente.repositories;

import com.rodrigo.pontointeligente.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

//JpaRepository<Empresa, Long> - Empresa é a entidade e Long é o tipo do ID
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Transactional(readOnly = true) - Não é necessário abrir uma transação no banco de dados
    @Transactional(readOnly = true)
    Empresa findByCnpj(String cnpj);

}
