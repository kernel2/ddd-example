package fr.victorianfashion.api.use_cases.recycle;

import fr.victorianfashion.api.domain.recycle.Recycle;

public interface RecycleRepository {
  void save(Recycle recycle);
}
