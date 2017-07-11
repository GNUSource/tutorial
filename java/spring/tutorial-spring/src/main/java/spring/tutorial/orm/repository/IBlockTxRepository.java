package spring.tutorial.orm.repository;

import spring.tutorial.orm.domain.BlockTx;

import java.util.List;

public interface IBlockTxRepository {

    List<BlockTx> findAll();
}
