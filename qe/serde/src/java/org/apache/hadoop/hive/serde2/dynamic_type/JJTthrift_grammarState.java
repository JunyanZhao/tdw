/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated By:JavaCC: Do not edit this line. JJTthrift_grammarState.java Version 4.1 */
package org.apache.hadoop.hive.serde2.dynamic_type;

public class JJTthrift_grammarState {
  private java.util.List nodes;
  private java.util.List marks;

  private int sp;
  private int mk;
  private boolean node_created;

  public JJTthrift_grammarState() {
    nodes = new java.util.ArrayList();
    marks = new java.util.ArrayList();
    sp = 0;
    mk = 0;
  }

  public boolean nodeCreated() {
    return node_created;
  }

  public void reset() {
    nodes.clear();
    marks.clear();
    sp = 0;
    mk = 0;
  }

  public Node rootNode() {
    return (Node) nodes.get(0);
  }

  /* Pushes a node on to the stack. */
  public void pushNode(Node n) {
    nodes.add(n);
    ++sp;
  }

  public Node popNode() {
    if (--sp < mk) {
      mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
    }
    return (Node) nodes.remove(nodes.size() - 1);
  }

  /* Returns the node currently on the top of the stack. */
  public Node peekNode() {
    return (Node) nodes.get(nodes.size() - 1);
  }

  public int nodeArity() {
    return sp - mk;
  }

  public void clearNodeScope(Node n) {
    while (sp > mk) {
      popNode();
    }
    mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
  }

  public void openNodeScope(Node n) {
    marks.add(new Integer(mk));
    mk = sp;
    n.jjtOpen();
  }

  public void closeNodeScope(Node n, int num) {
    mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
    while (num-- > 0) {
      Node c = popNode();
      c.jjtSetParent(n);
      n.jjtAddChild(c, num);
    }
    n.jjtClose();
    pushNode(n);
    node_created = true;
  }

  public void closeNodeScope(Node n, boolean condition) {
    if (condition) {
      int a = nodeArity();
      mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
      while (a-- > 0) {
        Node c = popNode();
        c.jjtSetParent(n);
        n.jjtAddChild(c, a);
      }
      n.jjtClose();
      pushNode(n);
      node_created = true;
    } else {
      mk = ((Integer) marks.remove(marks.size() - 1)).intValue();
      node_created = false;
    }
  }
}