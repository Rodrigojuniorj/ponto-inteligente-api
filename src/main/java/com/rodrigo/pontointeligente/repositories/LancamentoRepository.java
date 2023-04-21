package com.rodrigo.pontointeligente.repositories;

import java.util.List;

import com.rodrigo.pontointeligente.entities.Lancamento;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
// namedQueries - Consultas nomeadas que o spring nao consegue fazer sozinho
@NamedQueries({
        @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
                query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    // pageble - Paginação
    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
