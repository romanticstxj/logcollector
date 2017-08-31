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
public class Geo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 83015721285107840L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Geo\",\"namespace\":\"com.madhouse.ssp.avro\",\"fields\":[{\"name\":\"type\",\"type\":\"int\",\"default\":0},{\"name\":\"lat\",\"type\":\"float\",\"default\":0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Geo> ENCODER =
      new BinaryMessageEncoder<Geo>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Geo> DECODER =
      new BinaryMessageDecoder<Geo>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Geo> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Geo> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Geo>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Geo to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Geo from a ByteBuffer. */
  public static Geo fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int type;
  @Deprecated public float lat;
  @Deprecated public float lon;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Geo() {}

  /**
   * All-args constructor.
   * @param type The new value for type
   * @param lat The new value for lat
   * @param lon The new value for lon
   */
  public Geo(java.lang.Integer type, java.lang.Float lat, java.lang.Float lon) {
    this.type = type;
    this.lat = lat;
    this.lon = lon;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return type;
    case 1: return lat;
    case 2: return lon;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: type = (java.lang.Integer)value$; break;
    case 1: lat = (java.lang.Float)value$; break;
    case 2: lon = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.Integer getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.Integer value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'lat' field.
   * @return The value of the 'lat' field.
   */
  public java.lang.Float getLat() {
    return lat;
  }

  /**
   * Sets the value of the 'lat' field.
   * @param value the value to set.
   */
  public void setLat(java.lang.Float value) {
    this.lat = value;
  }

  /**
   * Gets the value of the 'lon' field.
   * @return The value of the 'lon' field.
   */
  public java.lang.Float getLon() {
    return lon;
  }

  /**
   * Sets the value of the 'lon' field.
   * @param value the value to set.
   */
  public void setLon(java.lang.Float value) {
    this.lon = value;
  }

  /**
   * Creates a new Geo RecordBuilder.
   * @return A new Geo RecordBuilder
   */
  public static com.madhouse.ssp.avro.Geo.Builder newBuilder() {
    return new com.madhouse.ssp.avro.Geo.Builder();
  }

  /**
   * Creates a new Geo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Geo RecordBuilder
   */
  public static com.madhouse.ssp.avro.Geo.Builder newBuilder(com.madhouse.ssp.avro.Geo.Builder other) {
    return new com.madhouse.ssp.avro.Geo.Builder(other);
  }

  /**
   * Creates a new Geo RecordBuilder by copying an existing Geo instance.
   * @param other The existing instance to copy.
   * @return A new Geo RecordBuilder
   */
  public static com.madhouse.ssp.avro.Geo.Builder newBuilder(com.madhouse.ssp.avro.Geo other) {
    return new com.madhouse.ssp.avro.Geo.Builder(other);
  }

  /**
   * RecordBuilder for Geo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Geo>
    implements org.apache.avro.data.RecordBuilder<Geo> {

    private int type;
    private float lat;
    private float lon;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.madhouse.ssp.avro.Geo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lat)) {
        this.lat = data().deepCopy(fields()[1].schema(), other.lat);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lon)) {
        this.lon = data().deepCopy(fields()[2].schema(), other.lon);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Geo instance
     * @param other The existing instance to copy.
     */
    private Builder(com.madhouse.ssp.avro.Geo other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lat)) {
        this.lat = data().deepCopy(fields()[1].schema(), other.lat);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lon)) {
        this.lon = data().deepCopy(fields()[2].schema(), other.lon);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.Integer getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder setType(int value) {
      validate(fields()[0], value);
      this.type = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder clearType() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'lat' field.
      * @return The value.
      */
    public java.lang.Float getLat() {
      return lat;
    }

    /**
      * Sets the value of the 'lat' field.
      * @param value The value of 'lat'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder setLat(float value) {
      validate(fields()[1], value);
      this.lat = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lat' field has been set.
      * @return True if the 'lat' field has been set, false otherwise.
      */
    public boolean hasLat() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lat' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder clearLat() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'lon' field.
      * @return The value.
      */
    public java.lang.Float getLon() {
      return lon;
    }

    /**
      * Sets the value of the 'lon' field.
      * @param value The value of 'lon'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder setLon(float value) {
      validate(fields()[2], value);
      this.lon = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'lon' field has been set.
      * @return True if the 'lon' field has been set, false otherwise.
      */
    public boolean hasLon() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'lon' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Geo.Builder clearLon() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Geo build() {
      try {
        Geo record = new Geo();
        record.type = fieldSetFlags()[0] ? this.type : (java.lang.Integer) defaultValue(fields()[0]);
        record.lat = fieldSetFlags()[1] ? this.lat : (java.lang.Float) defaultValue(fields()[1]);
        record.lon = fieldSetFlags()[2] ? this.lon : (java.lang.Float) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Geo>
    WRITER$ = (org.apache.avro.io.DatumWriter<Geo>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Geo>
    READER$ = (org.apache.avro.io.DatumReader<Geo>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
