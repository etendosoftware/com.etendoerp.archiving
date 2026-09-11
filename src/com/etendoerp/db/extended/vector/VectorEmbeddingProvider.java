package com.etendoerp.db.extended.vector;

import java.util.List;

/** Provider-neutral conversion of indexable text into a vector. */
public interface VectorEmbeddingProvider {
  /**
   * Embeds several texts in a single provider request.
   *
   * @param texts
   *     inputs to embed, at most {@link #batchSize()} of them
   * @return one embedding per input, in the same order
   */
  List<double[]> embed(List<String> texts);

  /** Maximum number of inputs the provider accepts in one request. */
  int batchSize();

  int dimensions();

  /** Embeds a single text. Kept for callers that have nothing to batch. */
  default double[] embed(String text) {
    return embed(List.of(text)).get(0);
  }
}
