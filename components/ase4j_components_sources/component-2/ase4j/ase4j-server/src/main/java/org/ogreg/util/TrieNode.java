package org.ogreg.util;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A trie node.
 * 
 * @author Gergely Kiss
 * @see Trie
 */
final class TrieNode<T> implements Serializable {
	private static final long serialVersionUID = 7217023895828169766L;

	final Trie<T> parent;
	final int offset;
	int count;

	T value;
	TrieNode<T>[] children = null;

	TrieNode(Trie<T> parent, int offset, int count, T value) {
		this.parent = parent;
		this.offset = offset;
		this.count = count;
		this.value = value;
	}

	T get(byte[] word, int offset, int length) {
		TrieNode<T> node = this;

		byte[] contents = parent.contents;
		int wordPos = 0;

		while (node != null) {
			int pos = node.getLongestMatch(contents, word, wordPos);
			int wps = pos + wordPos;

			if (wps == length) {
				return pos == node.count ? node.value : null;
			}

			if (node.children == null) {
				return null;
			}

			int charPos = word[offset + wps];

			node = node.children[charPos];
			wordPos = wps;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	void set(byte[] word, T value) {
		TrieNode<T> node = this;

		byte[] contents = parent.contents;
		int wordPos = 0;
		int pos;
		int wps;

		while (true) {
			pos = node.getLongestMatch(contents, word, wordPos);
			wps = pos + wordPos;

			// No match - adding the new word
			if (pos == 0) {
				int charPos = word[wps];

				if (node.children == null) {
					node.children = new TrieNode[parent.maxChildren];
				}

				if (node.children[charPos] == null) {
					// No node at this child, creating new one
					node.children[charPos] = parent.create(word, wordPos, value);
				} else {
					// Continue adding to current child
					node = node.children[charPos];
					continue;
				}
			}
			// We have a match
			else {
				int wordLen = word.length - wordPos;
				int prefixLen = node.count;

				if (pos < prefixLen) {
					// ... and there are remaining chars - splitting the
					// node (creating: a non-word prefix with two children)
					if (pos < wordLen) {
						TrieNode<T> child1 = parent.create(word, wps, value);
						TrieNode<T> child2 = node.subtrie(pos, node.value);
						child2.children = node.children;

						node.count = pos; // Keeping the first half
						node.value = null;
						node.children = new TrieNode[parent.maxChildren];
						node.children[child1.byteAt(0)] = child1;
						node.children[child2.byteAt(0)] = child2;
					}
					// ...and we have an exact match - splitting the node
					// (creating: a prefix which is the same as the new
					// word, with one child)
					else {
						TrieNode<T> child2 = node.subtrie(pos, node.value);
						child2.children = node.children;

						node.count = pos; // Keeping the first half
						node.value = value;
						node.children = new TrieNode[parent.maxChildren];
						node.children[child2.byteAt(0)] = child2;
					}
				}
				// Match is as long as the prefix
				else {
					// ...and there are remaining chars - adding remainder
					// to children
					if (pos < wordLen) {
						int charPos = word[wps];

						if (node.children == null) {
							node.children = new TrieNode[parent.maxChildren];
						}

						if (node.children[charPos] == null) {
							node.children[charPos] = parent.create(word, wps, value);
						} else {
							node = node.children[charPos];
							wordPos = wps;
							continue;
						}
					}
					// ...and we have an exact match - updating value
					else {
						node.value = value;
					}
				}
			}

			break;
		}
	}

	final byte byteAt(int i) {
		return parent.contents[offset + i];
	}

	private TrieNode<T> subtrie(int beginIndex, T value) {
		return (beginIndex == 0) ? this : new TrieNode<T>(parent, offset + beginIndex, count
				- beginIndex, value);
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(parent.contents, offset, offset + count));
	}

	/**
	 * Returns the longest matching position of the two strings.
	 * 
	 * @param word
	 * @return
	 */
	private final int getLongestMatch(byte[] contents, byte[] word, int wordOffset) {
		int len = Math.min(count, word.length - wordOffset);
		int po = this.offset;

		for (int i = 0; i < len; i++) {
			if (contents[po + i] != word[wordOffset + i]) {
				return i;
			}
		}
		return len;
	}
}