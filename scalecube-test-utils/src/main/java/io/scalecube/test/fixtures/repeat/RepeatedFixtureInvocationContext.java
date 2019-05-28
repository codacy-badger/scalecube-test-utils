package io.scalecube.test.fixtures.repeat;

import io.scalecube.test.fixtures.Fixture;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

public class RepeatedFixtureInvocationContext
    implements TestTemplateInvocationContext, RepetitionInfo {

  private final Fixture fixture;
  private final int currentRepetition;
  private final int totalRepetitions;
  private final RepeatedTestDisplayNameFormatter formatter;

  public RepeatedFixtureInvocationContext(
      Repeat repeat,
      Fixture fixture,
      int currentRepetition,
      int totalRepetitions,
      RepeatedTestDisplayNameFormatter formatter) {
    this.fixture = fixture;
    this.currentRepetition = currentRepetition;
    this.totalRepetitions = totalRepetitions;
    this.formatter = formatter;
  }

  public Fixture getFixture() {
    return this.fixture;
  }

  @Override
  public String getDisplayName(int invocationIndex) {
    return this.formatter.format(this.currentRepetition, this.totalRepetitions);
  }

  @Override
  public int getCurrentRepetition() {
    return this.currentRepetition;
  }

  @Override
  public int getTotalRepetitions() {
    return this.totalRepetitions;
  }
}