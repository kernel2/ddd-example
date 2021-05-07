package fr.victorianfashion.api.use_cases.Recycle;

import fr.victorianfashion.api.domain.Recycle.Recycling;

public interface RecycleRepository {
    void save(Recycling recycle);
}
