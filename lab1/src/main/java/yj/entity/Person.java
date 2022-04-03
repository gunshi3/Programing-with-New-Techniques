package yj.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person { //person表
  private String username;
  private String name;
  private Integer age;
  private String teleno;
}
