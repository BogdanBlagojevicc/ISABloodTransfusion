package com.example.isa.service;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Term;
import com.example.isa.repository.TermRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class TermService {
    private final TermRepository termRepository;

    @Autowired
    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    @Transactional
    public Term create(Term term) throws Exception {
        if (term.getId() != null) {
            throw new Exception("ID must be null");
        }

       // termRepository.findWithLockingById(term.getId());
        //if(termRepository.findWithLockingById(term.getId()).isEmpty()){
        //if(termRepository.findById(term.getId()) == null){
            
            List<Term> terms = this.termRepository.findAll();
            //List<Term> terms = this.termRepository.findAllWithLocking().get();
            Long hour = (long) 1;
            Integer counter = 0;
            for(Term t : terms){
                if((t.getDateTerm().compareTo(term.getDateTerm()) < 0 && t.getDateTerm().plusHours(hour).compareTo(term.getDateTerm()) > 0) || (term.getDateTerm().compareTo(t.getDateTerm()) < 0 && term.getDateTerm().plusHours(hour).compareTo(t.getDateTerm()) > 0)){
                    counter ++;
                    System.out.println("USAOOOOOOOOOO");
                    System.out.println("t.getDateTerm()  je:" + t.getDateTerm().toString());
                    System.out.println("t.getDateTerm().plusHours(hour)  je:" + t.getDateTerm().plusHours(hour).toString());
                }
            }

            if(counter == 0){
                Term savedTerm = this.termRepository.save(term);
                Thread.sleep(3_000);
                return savedTerm;
            }
            //Thread.sleep(1_000);
            
            //Throw new Exception("");
       // }
        throw new Exception("Term is null");
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
        Term term = this.termRepository.findById(id).get();

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

    public boolean checkIsTermInFuture(LocalDateTime localDateTime){
        LocalDateTime now = LocalDateTime.now();
        if(localDateTime.isBefore(now)){
            return false;
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

    public List<Term> findByDateTermAsc(Long id){

        List<Term> allTerms = termRepository.findByRegularUserIdOrderByDateTermAsc(id);

        List<Term> scheduledTerms = new ArrayList<Term>();

        LocalDateTime now = LocalDateTime.now();

        for(Term t : allTerms){
            if(t.getDateTerm().isAfter(now)){
                scheduledTerms.add(t);
            }
        }

        return scheduledTerms;
    }

    public List<Term> findByDateTermDesc(Long id){
        List<Term> allTerms = termRepository.findByRegularUserIdOrderByDateTermDesc(id);

        List<Term> scheduledTerms = new ArrayList<Term>();

        LocalDateTime now = LocalDateTime.now();

        for(Term t : allTerms){
            if(t.getDateTerm().isAfter(now)){
                scheduledTerms.add(t);
            }
        }

        return scheduledTerms;
    }

    public List<Term> findTermsForCenter(Long id){
        List<Term> terms = termRepository.findByCenterTermId(id);

        LocalDateTime now = LocalDateTime.now();

        List<Term> futureTerms = new ArrayList<Term>();

        for(Term t : terms){
            if(t.getDateTerm().isAfter(now) && t.getRegularUser() == null){
                futureTerms.add(t);
            }
        }

        return futureTerms;
    }
}
