/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.madhouse.ssp.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MediaResponse extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6286346188422393959L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MediaResponse\",\"namespace\":\"com.madhouse.ssp.avro\",\"fields\":[{\"name\":\"dspid\",\"type\":\"long\"},{\"name\":\"cid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"crid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"admid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"layout\",\"type\":\"int\",\"default\":0},{\"name\":\"icon\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"cover\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"title\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"desc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"duration\",\"type\":\"int\",\"default\":0},{\"name\":\"adm\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"dealid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"lpgurl\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"acttype\",\"type\":\"int\",\"default\":1},{\"name\":\"monitor\",\"type\":{\"type\":\"record\",\"name\":\"Monitor\",\"fields\":[{\"name\":\"impurl\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Track\",\"fields\":[{\"name\":\"startdelay\",\"type\":\"int\",\"default\":0},{\"name\":\"url\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}},{\"name\":\"clkurl\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"securl\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"exts\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<MediaResponse> ENCODER =
      new BinaryMessageEncoder<MediaResponse>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MediaResponse> DECODER =
      new BinaryMessageDecoder<MediaResponse>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<MediaResponse> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<MediaResponse> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<MediaResponse>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this MediaResponse to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a MediaResponse from a ByteBuffer. */
  public static MediaResponse fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long dspid;
  @Deprecated public java.lang.String cid;
  @Deprecated public java.lang.String crid;
  @Deprecated public java.lang.String admid;
  @Deprecated public int layout;
  @Deprecated public java.lang.String icon;
  @Deprecated public java.lang.String cover;
  @Deprecated public java.lang.String title;
  @Deprecated public java.lang.String desc;
  @Deprecated public int duration;
  @Deprecated public java.util.List<java.lang.String> adm;
  @Deprecated public java.lang.String dealid;
  @Deprecated public java.lang.String lpgurl;
  @Deprecated public int acttype;
  @Deprecated public com.madhouse.ssp.avro.Monitor monitor;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MediaResponse() {}

  /**
   * All-args constructor.
   * @param dspid The new value for dspid
   * @param cid The new value for cid
   * @param crid The new value for crid
   * @param admid The new value for admid
   * @param layout The new value for layout
   * @param icon The new value for icon
   * @param cover The new value for cover
   * @param title The new value for title
   * @param desc The new value for desc
   * @param duration The new value for duration
   * @param adm The new value for adm
   * @param dealid The new value for dealid
   * @param lpgurl The new value for lpgurl
   * @param acttype The new value for acttype
   * @param monitor The new value for monitor
   */
  public MediaResponse(java.lang.Long dspid, java.lang.String cid, java.lang.String crid, java.lang.String admid, java.lang.Integer layout, java.lang.String icon, java.lang.String cover, java.lang.String title, java.lang.String desc, java.lang.Integer duration, java.util.List<java.lang.String> adm, java.lang.String dealid, java.lang.String lpgurl, java.lang.Integer acttype, com.madhouse.ssp.avro.Monitor monitor) {
    this.dspid = dspid;
    this.cid = cid;
    this.crid = crid;
    this.admid = admid;
    this.layout = layout;
    this.icon = icon;
    this.cover = cover;
    this.title = title;
    this.desc = desc;
    this.duration = duration;
    this.adm = adm;
    this.dealid = dealid;
    this.lpgurl = lpgurl;
    this.acttype = acttype;
    this.monitor = monitor;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dspid;
    case 1: return cid;
    case 2: return crid;
    case 3: return admid;
    case 4: return layout;
    case 5: return icon;
    case 6: return cover;
    case 7: return title;
    case 8: return desc;
    case 9: return duration;
    case 10: return adm;
    case 11: return dealid;
    case 12: return lpgurl;
    case 13: return acttype;
    case 14: return monitor;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dspid = (java.lang.Long)value$; break;
    case 1: cid = (java.lang.String)value$; break;
    case 2: crid = (java.lang.String)value$; break;
    case 3: admid = (java.lang.String)value$; break;
    case 4: layout = (java.lang.Integer)value$; break;
    case 5: icon = (java.lang.String)value$; break;
    case 6: cover = (java.lang.String)value$; break;
    case 7: title = (java.lang.String)value$; break;
    case 8: desc = (java.lang.String)value$; break;
    case 9: duration = (java.lang.Integer)value$; break;
    case 10: adm = (java.util.List<java.lang.String>)value$; break;
    case 11: dealid = (java.lang.String)value$; break;
    case 12: lpgurl = (java.lang.String)value$; break;
    case 13: acttype = (java.lang.Integer)value$; break;
    case 14: monitor = (com.madhouse.ssp.avro.Monitor)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'dspid' field.
   * @return The value of the 'dspid' field.
   */
  public java.lang.Long getDspid() {
    return dspid;
  }

  /**
   * Sets the value of the 'dspid' field.
   * @param value the value to set.
   */
  public void setDspid(java.lang.Long value) {
    this.dspid = value;
  }

  /**
   * Gets the value of the 'cid' field.
   * @return The value of the 'cid' field.
   */
  public java.lang.String getCid() {
    return cid;
  }

  /**
   * Sets the value of the 'cid' field.
   * @param value the value to set.
   */
  public void setCid(java.lang.String value) {
    this.cid = value;
  }

  /**
   * Gets the value of the 'crid' field.
   * @return The value of the 'crid' field.
   */
  public java.lang.String getCrid() {
    return crid;
  }

  /**
   * Sets the value of the 'crid' field.
   * @param value the value to set.
   */
  public void setCrid(java.lang.String value) {
    this.crid = value;
  }

  /**
   * Gets the value of the 'admid' field.
   * @return The value of the 'admid' field.
   */
  public java.lang.String getAdmid() {
    return admid;
  }

  /**
   * Sets the value of the 'admid' field.
   * @param value the value to set.
   */
  public void setAdmid(java.lang.String value) {
    this.admid = value;
  }

  /**
   * Gets the value of the 'layout' field.
   * @return The value of the 'layout' field.
   */
  public java.lang.Integer getLayout() {
    return layout;
  }

  /**
   * Sets the value of the 'layout' field.
   * @param value the value to set.
   */
  public void setLayout(java.lang.Integer value) {
    this.layout = value;
  }

  /**
   * Gets the value of the 'icon' field.
   * @return The value of the 'icon' field.
   */
  public java.lang.String getIcon() {
    return icon;
  }

  /**
   * Sets the value of the 'icon' field.
   * @param value the value to set.
   */
  public void setIcon(java.lang.String value) {
    this.icon = value;
  }

  /**
   * Gets the value of the 'cover' field.
   * @return The value of the 'cover' field.
   */
  public java.lang.String getCover() {
    return cover;
  }

  /**
   * Sets the value of the 'cover' field.
   * @param value the value to set.
   */
  public void setCover(java.lang.String value) {
    this.cover = value;
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.String getTitle() {
    return title;
  }

  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.String value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'desc' field.
   * @return The value of the 'desc' field.
   */
  public java.lang.String getDesc() {
    return desc;
  }

  /**
   * Sets the value of the 'desc' field.
   * @param value the value to set.
   */
  public void setDesc(java.lang.String value) {
    this.desc = value;
  }

  /**
   * Gets the value of the 'duration' field.
   * @return The value of the 'duration' field.
   */
  public java.lang.Integer getDuration() {
    return duration;
  }

  /**
   * Sets the value of the 'duration' field.
   * @param value the value to set.
   */
  public void setDuration(java.lang.Integer value) {
    this.duration = value;
  }

  /**
   * Gets the value of the 'adm' field.
   * @return The value of the 'adm' field.
   */
  public java.util.List<java.lang.String> getAdm() {
    return adm;
  }

  /**
   * Sets the value of the 'adm' field.
   * @param value the value to set.
   */
  public void setAdm(java.util.List<java.lang.String> value) {
    this.adm = value;
  }

  /**
   * Gets the value of the 'dealid' field.
   * @return The value of the 'dealid' field.
   */
  public java.lang.String getDealid() {
    return dealid;
  }

  /**
   * Sets the value of the 'dealid' field.
   * @param value the value to set.
   */
  public void setDealid(java.lang.String value) {
    this.dealid = value;
  }

  /**
   * Gets the value of the 'lpgurl' field.
   * @return The value of the 'lpgurl' field.
   */
  public java.lang.String getLpgurl() {
    return lpgurl;
  }

  /**
   * Sets the value of the 'lpgurl' field.
   * @param value the value to set.
   */
  public void setLpgurl(java.lang.String value) {
    this.lpgurl = value;
  }

  /**
   * Gets the value of the 'acttype' field.
   * @return The value of the 'acttype' field.
   */
  public java.lang.Integer getActtype() {
    return acttype;
  }

  /**
   * Sets the value of the 'acttype' field.
   * @param value the value to set.
   */
  public void setActtype(java.lang.Integer value) {
    this.acttype = value;
  }

  /**
   * Gets the value of the 'monitor' field.
   * @return The value of the 'monitor' field.
   */
  public com.madhouse.ssp.avro.Monitor getMonitor() {
    return monitor;
  }

  /**
   * Sets the value of the 'monitor' field.
   * @param value the value to set.
   */
  public void setMonitor(com.madhouse.ssp.avro.Monitor value) {
    this.monitor = value;
  }

  /**
   * Creates a new MediaResponse RecordBuilder.
   * @return A new MediaResponse RecordBuilder
   */
  public static com.madhouse.ssp.avro.MediaResponse.Builder newBuilder() {
    return new com.madhouse.ssp.avro.MediaResponse.Builder();
  }

  /**
   * Creates a new MediaResponse RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MediaResponse RecordBuilder
   */
  public static com.madhouse.ssp.avro.MediaResponse.Builder newBuilder(com.madhouse.ssp.avro.MediaResponse.Builder other) {
    return new com.madhouse.ssp.avro.MediaResponse.Builder(other);
  }

  /**
   * Creates a new MediaResponse RecordBuilder by copying an existing MediaResponse instance.
   * @param other The existing instance to copy.
   * @return A new MediaResponse RecordBuilder
   */
  public static com.madhouse.ssp.avro.MediaResponse.Builder newBuilder(com.madhouse.ssp.avro.MediaResponse other) {
    return new com.madhouse.ssp.avro.MediaResponse.Builder(other);
  }

  /**
   * RecordBuilder for MediaResponse instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MediaResponse>
    implements org.apache.avro.data.RecordBuilder<MediaResponse> {

    private long dspid;
    private java.lang.String cid;
    private java.lang.String crid;
    private java.lang.String admid;
    private int layout;
    private java.lang.String icon;
    private java.lang.String cover;
    private java.lang.String title;
    private java.lang.String desc;
    private int duration;
    private java.util.List<java.lang.String> adm;
    private java.lang.String dealid;
    private java.lang.String lpgurl;
    private int acttype;
    private com.madhouse.ssp.avro.Monitor monitor;
    private com.madhouse.ssp.avro.Monitor.Builder monitorBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.madhouse.ssp.avro.MediaResponse.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dspid)) {
        this.dspid = data().deepCopy(fields()[0].schema(), other.dspid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cid)) {
        this.cid = data().deepCopy(fields()[1].schema(), other.cid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.crid)) {
        this.crid = data().deepCopy(fields()[2].schema(), other.crid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.admid)) {
        this.admid = data().deepCopy(fields()[3].schema(), other.admid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.layout)) {
        this.layout = data().deepCopy(fields()[4].schema(), other.layout);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.icon)) {
        this.icon = data().deepCopy(fields()[5].schema(), other.icon);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.cover)) {
        this.cover = data().deepCopy(fields()[6].schema(), other.cover);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.title)) {
        this.title = data().deepCopy(fields()[7].schema(), other.title);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.desc)) {
        this.desc = data().deepCopy(fields()[8].schema(), other.desc);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.duration)) {
        this.duration = data().deepCopy(fields()[9].schema(), other.duration);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.adm)) {
        this.adm = data().deepCopy(fields()[10].schema(), other.adm);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.dealid)) {
        this.dealid = data().deepCopy(fields()[11].schema(), other.dealid);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.lpgurl)) {
        this.lpgurl = data().deepCopy(fields()[12].schema(), other.lpgurl);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.acttype)) {
        this.acttype = data().deepCopy(fields()[13].schema(), other.acttype);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.monitor)) {
        this.monitor = data().deepCopy(fields()[14].schema(), other.monitor);
        fieldSetFlags()[14] = true;
      }
      if (other.hasMonitorBuilder()) {
        this.monitorBuilder = com.madhouse.ssp.avro.Monitor.newBuilder(other.getMonitorBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing MediaResponse instance
     * @param other The existing instance to copy.
     */
    private Builder(com.madhouse.ssp.avro.MediaResponse other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.dspid)) {
        this.dspid = data().deepCopy(fields()[0].schema(), other.dspid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.cid)) {
        this.cid = data().deepCopy(fields()[1].schema(), other.cid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.crid)) {
        this.crid = data().deepCopy(fields()[2].schema(), other.crid);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.admid)) {
        this.admid = data().deepCopy(fields()[3].schema(), other.admid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.layout)) {
        this.layout = data().deepCopy(fields()[4].schema(), other.layout);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.icon)) {
        this.icon = data().deepCopy(fields()[5].schema(), other.icon);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.cover)) {
        this.cover = data().deepCopy(fields()[6].schema(), other.cover);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.title)) {
        this.title = data().deepCopy(fields()[7].schema(), other.title);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.desc)) {
        this.desc = data().deepCopy(fields()[8].schema(), other.desc);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.duration)) {
        this.duration = data().deepCopy(fields()[9].schema(), other.duration);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.adm)) {
        this.adm = data().deepCopy(fields()[10].schema(), other.adm);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.dealid)) {
        this.dealid = data().deepCopy(fields()[11].schema(), other.dealid);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.lpgurl)) {
        this.lpgurl = data().deepCopy(fields()[12].schema(), other.lpgurl);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.acttype)) {
        this.acttype = data().deepCopy(fields()[13].schema(), other.acttype);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.monitor)) {
        this.monitor = data().deepCopy(fields()[14].schema(), other.monitor);
        fieldSetFlags()[14] = true;
      }
      this.monitorBuilder = null;
    }

    /**
      * Gets the value of the 'dspid' field.
      * @return The value.
      */
    public java.lang.Long getDspid() {
      return dspid;
    }

    /**
      * Sets the value of the 'dspid' field.
      * @param value The value of 'dspid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setDspid(long value) {
      validate(fields()[0], value);
      this.dspid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'dspid' field has been set.
      * @return True if the 'dspid' field has been set, false otherwise.
      */
    public boolean hasDspid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'dspid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearDspid() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'cid' field.
      * @return The value.
      */
    public java.lang.String getCid() {
      return cid;
    }

    /**
      * Sets the value of the 'cid' field.
      * @param value The value of 'cid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setCid(java.lang.String value) {
      validate(fields()[1], value);
      this.cid = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'cid' field has been set.
      * @return True if the 'cid' field has been set, false otherwise.
      */
    public boolean hasCid() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'cid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearCid() {
      cid = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'crid' field.
      * @return The value.
      */
    public java.lang.String getCrid() {
      return crid;
    }

    /**
      * Sets the value of the 'crid' field.
      * @param value The value of 'crid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setCrid(java.lang.String value) {
      validate(fields()[2], value);
      this.crid = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'crid' field has been set.
      * @return True if the 'crid' field has been set, false otherwise.
      */
    public boolean hasCrid() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'crid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearCrid() {
      crid = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'admid' field.
      * @return The value.
      */
    public java.lang.String getAdmid() {
      return admid;
    }

    /**
      * Sets the value of the 'admid' field.
      * @param value The value of 'admid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setAdmid(java.lang.String value) {
      validate(fields()[3], value);
      this.admid = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'admid' field has been set.
      * @return True if the 'admid' field has been set, false otherwise.
      */
    public boolean hasAdmid() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'admid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearAdmid() {
      admid = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'layout' field.
      * @return The value.
      */
    public java.lang.Integer getLayout() {
      return layout;
    }

    /**
      * Sets the value of the 'layout' field.
      * @param value The value of 'layout'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setLayout(int value) {
      validate(fields()[4], value);
      this.layout = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'layout' field has been set.
      * @return True if the 'layout' field has been set, false otherwise.
      */
    public boolean hasLayout() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'layout' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearLayout() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'icon' field.
      * @return The value.
      */
    public java.lang.String getIcon() {
      return icon;
    }

    /**
      * Sets the value of the 'icon' field.
      * @param value The value of 'icon'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setIcon(java.lang.String value) {
      validate(fields()[5], value);
      this.icon = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'icon' field has been set.
      * @return True if the 'icon' field has been set, false otherwise.
      */
    public boolean hasIcon() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'icon' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearIcon() {
      icon = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'cover' field.
      * @return The value.
      */
    public java.lang.String getCover() {
      return cover;
    }

    /**
      * Sets the value of the 'cover' field.
      * @param value The value of 'cover'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setCover(java.lang.String value) {
      validate(fields()[6], value);
      this.cover = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'cover' field has been set.
      * @return True if the 'cover' field has been set, false otherwise.
      */
    public boolean hasCover() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'cover' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearCover() {
      cover = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.String getTitle() {
      return title;
    }

    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setTitle(java.lang.String value) {
      validate(fields()[7], value);
      this.title = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearTitle() {
      title = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'desc' field.
      * @return The value.
      */
    public java.lang.String getDesc() {
      return desc;
    }

    /**
      * Sets the value of the 'desc' field.
      * @param value The value of 'desc'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setDesc(java.lang.String value) {
      validate(fields()[8], value);
      this.desc = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'desc' field has been set.
      * @return True if the 'desc' field has been set, false otherwise.
      */
    public boolean hasDesc() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'desc' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearDesc() {
      desc = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'duration' field.
      * @return The value.
      */
    public java.lang.Integer getDuration() {
      return duration;
    }

    /**
      * Sets the value of the 'duration' field.
      * @param value The value of 'duration'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setDuration(int value) {
      validate(fields()[9], value);
      this.duration = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'duration' field has been set.
      * @return True if the 'duration' field has been set, false otherwise.
      */
    public boolean hasDuration() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'duration' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearDuration() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'adm' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getAdm() {
      return adm;
    }

    /**
      * Sets the value of the 'adm' field.
      * @param value The value of 'adm'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setAdm(java.util.List<java.lang.String> value) {
      validate(fields()[10], value);
      this.adm = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'adm' field has been set.
      * @return True if the 'adm' field has been set, false otherwise.
      */
    public boolean hasAdm() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'adm' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearAdm() {
      adm = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'dealid' field.
      * @return The value.
      */
    public java.lang.String getDealid() {
      return dealid;
    }

    /**
      * Sets the value of the 'dealid' field.
      * @param value The value of 'dealid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setDealid(java.lang.String value) {
      validate(fields()[11], value);
      this.dealid = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'dealid' field has been set.
      * @return True if the 'dealid' field has been set, false otherwise.
      */
    public boolean hasDealid() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'dealid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearDealid() {
      dealid = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'lpgurl' field.
      * @return The value.
      */
    public java.lang.String getLpgurl() {
      return lpgurl;
    }

    /**
      * Sets the value of the 'lpgurl' field.
      * @param value The value of 'lpgurl'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setLpgurl(java.lang.String value) {
      validate(fields()[12], value);
      this.lpgurl = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'lpgurl' field has been set.
      * @return True if the 'lpgurl' field has been set, false otherwise.
      */
    public boolean hasLpgurl() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'lpgurl' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearLpgurl() {
      lpgurl = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'acttype' field.
      * @return The value.
      */
    public java.lang.Integer getActtype() {
      return acttype;
    }

    /**
      * Sets the value of the 'acttype' field.
      * @param value The value of 'acttype'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setActtype(int value) {
      validate(fields()[13], value);
      this.acttype = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'acttype' field has been set.
      * @return True if the 'acttype' field has been set, false otherwise.
      */
    public boolean hasActtype() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'acttype' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearActtype() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /**
      * Gets the value of the 'monitor' field.
      * @return The value.
      */
    public com.madhouse.ssp.avro.Monitor getMonitor() {
      return monitor;
    }

    /**
      * Sets the value of the 'monitor' field.
      * @param value The value of 'monitor'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder setMonitor(com.madhouse.ssp.avro.Monitor value) {
      validate(fields()[14], value);
      this.monitorBuilder = null;
      this.monitor = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'monitor' field has been set.
      * @return True if the 'monitor' field has been set, false otherwise.
      */
    public boolean hasMonitor() {
      return fieldSetFlags()[14];
    }

    /**
     * Gets the Builder instance for the 'monitor' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.madhouse.ssp.avro.Monitor.Builder getMonitorBuilder() {
      if (monitorBuilder == null) {
        if (hasMonitor()) {
          setMonitorBuilder(com.madhouse.ssp.avro.Monitor.newBuilder(monitor));
        } else {
          setMonitorBuilder(com.madhouse.ssp.avro.Monitor.newBuilder());
        }
      }
      return monitorBuilder;
    }

    /**
     * Sets the Builder instance for the 'monitor' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.madhouse.ssp.avro.MediaResponse.Builder setMonitorBuilder(com.madhouse.ssp.avro.Monitor.Builder value) {
      clearMonitor();
      monitorBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'monitor' field has an active Builder instance
     * @return True if the 'monitor' field has an active Builder instance
     */
    public boolean hasMonitorBuilder() {
      return monitorBuilder != null;
    }

    /**
      * Clears the value of the 'monitor' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.MediaResponse.Builder clearMonitor() {
      monitor = null;
      monitorBuilder = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MediaResponse build() {
      try {
        MediaResponse record = new MediaResponse();
        record.dspid = fieldSetFlags()[0] ? this.dspid : (java.lang.Long) defaultValue(fields()[0]);
        record.cid = fieldSetFlags()[1] ? this.cid : (java.lang.String) defaultValue(fields()[1]);
        record.crid = fieldSetFlags()[2] ? this.crid : (java.lang.String) defaultValue(fields()[2]);
        record.admid = fieldSetFlags()[3] ? this.admid : (java.lang.String) defaultValue(fields()[3]);
        record.layout = fieldSetFlags()[4] ? this.layout : (java.lang.Integer) defaultValue(fields()[4]);
        record.icon = fieldSetFlags()[5] ? this.icon : (java.lang.String) defaultValue(fields()[5]);
        record.cover = fieldSetFlags()[6] ? this.cover : (java.lang.String) defaultValue(fields()[6]);
        record.title = fieldSetFlags()[7] ? this.title : (java.lang.String) defaultValue(fields()[7]);
        record.desc = fieldSetFlags()[8] ? this.desc : (java.lang.String) defaultValue(fields()[8]);
        record.duration = fieldSetFlags()[9] ? this.duration : (java.lang.Integer) defaultValue(fields()[9]);
        record.adm = fieldSetFlags()[10] ? this.adm : (java.util.List<java.lang.String>) defaultValue(fields()[10]);
        record.dealid = fieldSetFlags()[11] ? this.dealid : (java.lang.String) defaultValue(fields()[11]);
        record.lpgurl = fieldSetFlags()[12] ? this.lpgurl : (java.lang.String) defaultValue(fields()[12]);
        record.acttype = fieldSetFlags()[13] ? this.acttype : (java.lang.Integer) defaultValue(fields()[13]);
        if (monitorBuilder != null) {
          record.monitor = this.monitorBuilder.build();
        } else {
          record.monitor = fieldSetFlags()[14] ? this.monitor : (com.madhouse.ssp.avro.Monitor) defaultValue(fields()[14]);
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MediaResponse>
    WRITER$ = (org.apache.avro.io.DatumWriter<MediaResponse>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MediaResponse>
    READER$ = (org.apache.avro.io.DatumReader<MediaResponse>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}