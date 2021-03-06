package com.hubspot.httpql.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.jooq.SortOrder;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderingTest {

  private ObjectMapper mapper;

  @Before
  public void setup() {
    mapper = new ObjectMapper();
  }

  @Test
  public void testJsonWithField() throws Exception {
    Ordering o1 = new Ordering("foo", SortOrder.ASC);
    String json = mapper.writeValueAsString(o1);

    Ordering o2 = mapper.readValue(json, Ordering.class);
    assertThat(o2).isEqualToComparingFieldByField(o1);
    assertThat(o2.equals(o1)).isTrue();

    o1 = new Ordering("foo", SortOrder.DESC);
    json = mapper.writeValueAsString(o1);

    o2 = mapper.readValue(json, Ordering.class);
    assertThat(o2).isEqualToComparingFieldByField(o1);
  }

  @Test
  public void testJsonWithQueryField() throws Exception {
    Ordering o1 = new Ordering("foo", "bar", SortOrder.ASC);
    String json = mapper.writeValueAsString(o1);

    Ordering o2 = mapper.readValue(json, Ordering.class);
    assertThat(o2).isEqualToComparingFieldByField(o1);
    assertThat(o2.equals(o1)).isTrue();

    o1 = new Ordering("foo", "bar", SortOrder.DESC);
    json = mapper.writeValueAsString(o1);

    o2 = mapper.readValue(json, Ordering.class);
    assertThat(o2).isEqualToComparingFieldByField(o1);
  }

}
