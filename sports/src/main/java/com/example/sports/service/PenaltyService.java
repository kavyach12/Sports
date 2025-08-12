package com.example.sports.service;

import com.example.sports.model.Penalty;
import java.util.List;

public interface PenaltyService {
    Penalty addPenalty(Penalty penalty);
    List<Penalty> getAllPenalties();
}
