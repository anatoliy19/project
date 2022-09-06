package market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import market.model.enums.ApprovedStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

// TODO @Алексей Трояновский
// добавить поле из эпррувед  в виде енама - 2 статуса он чекинг и апррувед
// переделать все даты на зонайдитайм, иначе будут баги на фронте
// ликвид бейс
@Entity
public class Advertisement {

    @Id
    private Long id;

    @NotNull
    private ZonedDateTime createDate = ZonedDateTime.now(ZoneId.of("+3"));

    @Lob @Type(type = "org.hibernate.type.TextType")
    @NotBlank
    private String description;

    @NotNull
    private Boolean isArchived = false;


    @NotNull
    private ApprovedStatus isApproved = ApprovedStatus.ON_CHECKING;

    @NotNull
    private Long createdBy;

    private Boolean isPriority = false;

    @JsonIgnore
    @ElementCollection
    @NotNull
    private Set<Long> pictures;

    @JsonIgnore
    @ElementCollection
    @NotNull
    private Set<Long> likes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @NotNull
    private Item item;

    @JsonIgnore
    @ElementCollection
    private List<ZonedDateTime> expirationDate;

    public Advertisement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Set<Long> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Long> pictures) {
        this.pictures = pictures;
    }

    public Set<Long> getLikes() {
        return likes;
    }

    public void setLikes(Set<Long> likes) {
        this.likes = likes;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ApprovedStatus getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(ApprovedStatus isApproved) {
        this.isApproved = isApproved;
    }

    public void setPriority(Boolean isPriority) {
        this.isPriority = isPriority;
    }

    public Boolean getPriority(){
        return isPriority;
    }

    public List<ZonedDateTime> getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(List<ZonedDateTime> expirationDate) {
        this.expirationDate = expirationDate;
    }
}
