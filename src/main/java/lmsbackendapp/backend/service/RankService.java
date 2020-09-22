package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Rank;
import lmsbackendapp.backend.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankService {
    @Autowired
    private RankRepository rankRepo;

    public RankService() {
    }

    public Iterable<Rank> getRank() {
        return rankRepo.findAll();
    }

    public Optional<Rank> getRankById(Long id) {
        return rankRepo.findById(id);
    }
    public void addRank(Rank rank) {
        rankRepo.save(rank);
    }
    public void editRank(Long id,Rank rank) {
        Optional<Rank> rnk = rankRepo.findById(id);
        if(rnk.isPresent()) {
            rank.setId(rnk.get().getId());
            rankRepo.save(rank);
        }
    }
    public void deleteRank(Long id) {
        Optional<Rank> rnkDel = rankRepo.findById(id);
        rankRepo.delete(rnkDel.get());
    }
}
