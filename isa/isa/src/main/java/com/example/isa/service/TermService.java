package com.example.isa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Term;
import com.example.isa.repository.TermRepository;

@Service
public class TermService {
    private final TermRepository termRepository;

    @Autowired
    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public Term create(Term term) throws Exception {
        if (term.getId() != null) {
            throw new Exception("ID must be null");
        }
        return this.termRepository.save(term);
    }

    public List<Term> findAll() {
        return this.termRepository.findAll();

    }

    public Term update(Term term) throws Exception{
        if(term.getId() == null){
            throw new Exception("ID must be null");
        }

        return this.termRepository.save(term);
    }

    public Term removeUser(Term term) throws Exception{
        if(term.getId() == null){
            throw new Exception("ID must be null");
        }

        term.setRegularUser(null);

        return this.termRepository.save(term);
    }

    public List<Term> findByCenterIdOrderByDateTerm(Long id) {
        return termRepository.findByCenterIdOrderByDateTerm(id);
    }

    public Term findOne(Long id) throws Exception {
        Term term = this.termRepository.getById(id);

        if (term == null) {
            throw new Exception("Term does not exist");
        }

        return term;
    }

    public void delete(Term term) throws Exception {
        this.termRepository.delete(term);
    }

    public boolean checkTerm(List<Term> terms, LocalDateTime localDateTime) {
        for (Term t : terms) {
            LocalDateTime toTime = localDateTime.plusHours(1l);
            if ((localDateTime.isBefore(t.getDateTerm())
                    && (toTime.isAfter(t.getDateTerm()) && toTime.isBefore(localDateTime.plusHours(1l))))
                    || (localDateTime.isBefore(t.getDateTerm()) && toTime.isAfter(t.getDateTerm().plusHours(1l)))
                    || (localDateTime.isAfter(t.getDateTerm()) && localDateTime.isBefore(t.getDateTerm().plusHours(1l))
                            && toTime.isAfter(t.getDateTerm().plusHours(1l)))
                    || (localDateTime.equals(t.getDateTerm()) && toTime.equals(t.getDateTerm().plusHours(1l)))) {
                return false;
            }
        }
        return true;
    }

    public List<Term> findFinishedTermsByRegularUserId(Long id){
        List<Term> allTerms = termRepository.findAllByRegularUserId(id);

        List<Term> finishedTerms = new ArrayList<Term>();

        LocalDateTime now = LocalDateTime.now();

        for(Term t : allTerms){
            if(t.getDateTerm().isBefore(now)){
                finishedTerms.add(t);
            }
        }

        return finishedTerms;
    }

    public List<Term> findScheduledTerms(Long id){
        List<Term> allTerms = termRepository.findAllByRegularUserId(id);

        List<Term> scheduledTerms = new ArrayList<Term>();

        LocalDateTime now = LocalDateTime.now();

        for(Term t : allTerms){
            if(t.getDateTerm().isAfter(now)){
                scheduledTerms.add(t);
            }
        }

        return scheduledTerms;
    }

    public List<Term> findAllByRegularUserId(Long id){
        return termRepository.findAllByRegularUserId(id);
    }
}
