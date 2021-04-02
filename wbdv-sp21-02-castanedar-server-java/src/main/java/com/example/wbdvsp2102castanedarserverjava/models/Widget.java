package com.example.wbdvsp2102castanedarserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String topicId;
  private String name;
  private String type;
  private int widgetOrder;
  private Integer size;
  private String text;
  private Integer width;
  private Integer height;
  private String src;
  private String cssClass;
  private String value;
  private String style;
  private Boolean ordered;

  public Widget(Long id, String topicId, String type, Integer size, String text) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
  }

  public Widget() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(int widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }
}