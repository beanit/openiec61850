/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.iec61850bean.internal.mms.asn1;

import com.beanit.asn1bean.ber.BerTag;
import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;
import com.beanit.asn1bean.ber.types.BerType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class TypeSpecification implements BerType, Serializable {

  private static final long serialVersionUID = 1L;

  private byte[] code = null;
  private TypeDescription typeDescription = null;

  public TypeSpecification() {}

  public TypeSpecification(byte[] code) {
    this.code = code;
  }

  public TypeDescription getTypeDescription() {
    return typeDescription;
  }

  public void setTypeDescription(TypeDescription typeDescription) {
    this.typeDescription = typeDescription;
  }

  @Override
  public int encode(OutputStream reverseOS) throws IOException {

    if (code != null) {
      reverseOS.write(code);
      return code.length;
    }

    int codeLength = 0;
    if (typeDescription != null) {
      codeLength += typeDescription.encode(reverseOS);
      return codeLength;
    }

    throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
  }

  @Override
  public int decode(InputStream is) throws IOException {
    return decode(is, null);
  }

  public int decode(InputStream is, BerTag berTag) throws IOException {

    int tlvByteCount = 0;
    boolean tagWasPassed = (berTag != null);

    if (berTag == null) {
      berTag = new BerTag();
      tlvByteCount += berTag.decode(is);
    }

    int numDecodedBytes;

    typeDescription = new TypeDescription();
    numDecodedBytes = typeDescription.decode(is, berTag);
    if (numDecodedBytes != 0) {
      return tlvByteCount + numDecodedBytes;
    } else {
      typeDescription = null;
    }

    if (tagWasPassed) {
      return 0;
    }

    throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
  }

  public void encodeAndSave(int encodingSizeGuess) throws IOException {
    ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
    encode(reverseOS);
    code = reverseOS.getArray();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    appendAsString(sb, 0);
    return sb.toString();
  }

  public void appendAsString(StringBuilder sb, int indentLevel) {

    if (typeDescription != null) {
      sb.append("typeDescription: ");
      typeDescription.appendAsString(sb, indentLevel + 1);
      return;
    }

    sb.append("<none>");
  }
}
