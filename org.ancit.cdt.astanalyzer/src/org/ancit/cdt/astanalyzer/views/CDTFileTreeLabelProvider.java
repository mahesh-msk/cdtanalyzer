package org.ancit.cdt.astanalyzer.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTBinaryExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIfStatement;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;

/**
 * This class provides the labels for the AST tree
 */
@SuppressWarnings("restriction")
public class CDTFileTreeLabelProvider implements ILabelProvider {

	/**
	 * Gets the image to display for a node in the tree
	 * 
	 * @param arg0 the node
	 * @return Image
	 */
	@Override
	public Image getImage(Object node) {
		return null;
	}

	/**
	 * Gets the text to display for a node in the tree
	 * 
	 * @param arg0 the node
	 * @return String
	 */

	public String getText(Object iastNode) {
		// Get the name of the file
		String text = "";
		if (iastNode instanceof CPPASTFunctionDefinition) {
			CPPASTFunctionDefinition cppFunctionDefinition = (CPPASTFunctionDefinition) iastNode;
			text = cppFunctionDefinition.getRawSignature();
		} else if (iastNode instanceof CPPASTIfStatement) {
			CPPASTIfStatement ifStatement = (CPPASTIfStatement) iastNode;
			text = ifStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTBinaryExpression) {
			CPPASTBinaryExpression binaryExpression = (CPPASTBinaryExpression) iastNode;
			text = binaryExpression.getRawSignature();
		}

		return text;
	}

	/**
	 * Returns whether changes to the specified property on the specified element
	 * would affect the label for the element
	 * 
	 * @param arg0 the element
	 * @param arg1 the property
	 * @return boolean
	 */
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}
}