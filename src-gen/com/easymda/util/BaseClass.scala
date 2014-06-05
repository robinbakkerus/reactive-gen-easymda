package com.easymda.util
 
import org.apache.commons.lang3.builder.ToStringBuilder
 
abstract class FetchDepth()
 
abstract class BaseClass() {
  override def toString() = {
    ToStringBuilder.reflectionToString(this)
  }	
}
