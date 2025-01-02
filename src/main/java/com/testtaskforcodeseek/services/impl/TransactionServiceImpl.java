package com.testtaskforcodeseek.services.impl;

import com.testtaskforcodeseek.dtos.requests.TransactDto;
import com.testtaskforcodeseek.entities.Player;
import com.testtaskforcodeseek.entities.Team;
import com.testtaskforcodeseek.repositories.PlayerRepository;
import com.testtaskforcodeseek.repositories.TeamRepository;
import com.testtaskforcodeseek.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public void transactPlayer(TransactDto transactDto) {
        Player player = playerRepository.findById(transactDto.player()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Player with this id don't  exist"));
        Team owner = player.getTeam();
        Team buyer = teamRepository.findById(transactDto.buyer()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Buyer with this id don't  exist"));
        double price = player.getExperience() * 100000.0 / (LocalDateTime.now().getYear() - player.getBirthdate().getYear());
        if (owner != null) {
            if (!owner.getId().equals(buyer.getId())) {
                double commission = (price / 100) * owner.getCommission();
                if (price + commission <= buyer.getFunds()) {
                    buyer.setFunds(buyer.getFunds() - (price + commission));
                    owner.setFunds(owner.getFunds() + price + commission);
                    owner.getPlayers().remove(player);
                    player.setTeam(buyer);
                    buyer.getPlayers().add(player);
                } else {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Buyer don't has enough money");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Buyer already own the player");
            }
        } else {
                if (price <= buyer.getFunds()) {
                    buyer.setFunds(buyer.getFunds() - (price));
                    player.setTeam(buyer);
                    buyer.getPlayers().add(player);
                } else {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Buyer don't has enough money");
                }
        }

    }
}
