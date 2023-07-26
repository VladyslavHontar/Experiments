package bad_java.experiments.data;

import lombok.Value;

@Value
public class JobHistoryEntry {

  int duration;
  String position;
  String employer;
}
