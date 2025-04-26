package br.com.mario.repository.contract;

import java.util.List;

public interface ListRepository<T> {
    public List<T> listExec();
}
