package bad_java.experiments.data;

import lombok.Value;

import java.util.List;

@Value
public class Employee {

  Person person;
  List<JobHistoryEntry> jobHistory;
}
