package com.example.isa.service;

import javax.el.ELException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Term;
import com.example.isa.repository.TermRepository;

@Service
public class TermService {
    private final TermRepository termRepository;

    @Autowired
    public TermService(TermRepository termRepository){
        this.termRepository = termRepository;
    }

    public Term create (Term term) throws Exception{
        if(term.getId() != null){
            throw new Exception("ID must be null");
        }
        return this.termRepository.save(term);
    }

    public Term findOne(Long id) throws Exception{
        Term term = this.termRepository.getById(id);

        if(term == null){
            throw new Exception("Term does not exist");
        }

        return term;
    }

    public void delete(Term term) throws Exception{
        this.termRepository.delete(term);
    }
}
