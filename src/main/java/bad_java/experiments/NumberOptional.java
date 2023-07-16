package bad_java.experiments;

import java.util.NoSuchElementException;
import java.util.Objects;

public class NumberOptional<T extends Number>{
  private T value;

  public NumberOptional(T value) {
    this.value = value;
  }

  public boolean isPresent() {
    return value != null;
  }

  public boolean isEmpty() {
    return value == null;
  }

  public T get() {
    if (value == null) {
      throw new NoSuchElementException("Value is not present");
    }
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NumberOptional<?> that = (NumberOptional<?>) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value == null
            ? "Optional empty"
            : "bad_java.experimets.CustomOptional[" + "value=" + value + ']';
  }
}
