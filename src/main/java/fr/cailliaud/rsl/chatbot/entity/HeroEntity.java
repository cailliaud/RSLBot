package fr.cailliaud.rsl.chatbot.entity;

import fr.cailliaud.rsl.chatbot.domain.Faction;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@Entity
@Table(name = "hero")
@SequenceGenerator(
    name = "id_generateur_sequence",
    sequenceName = "hero_sequence",
    allocationSize = 1)
public class HeroEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generateur_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  @Column(name = "creation_time", updatable = false, nullable = false)
  @Setter(AccessLevel.NONE)
  private Timestamp creationTime;

  @Column(name = "modification_time")
  @Setter(AccessLevel.NONE)
  private Timestamp modificationTime;

  @Version
  @Setter(AccessLevel.NONE)
  private int version;

  @Column(nullable = false)
  private String nomAnglais;

  @Column(nullable = false)
  private String nomFrancais;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Faction faction;

  private String lienAlucare;
  private String lienMisterTix;
  private String lienInteleria;

  @PreUpdate
  public final void preUpdate() {
    modificationTime = new Timestamp(System.currentTimeMillis());
  }

  @PrePersist
  public final void prePersist() {
    creationTime = new Timestamp(System.currentTimeMillis());
    modificationTime = new Timestamp(System.currentTimeMillis());
  }
}
