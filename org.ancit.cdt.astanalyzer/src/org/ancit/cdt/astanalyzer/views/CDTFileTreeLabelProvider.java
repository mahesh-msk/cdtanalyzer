package org.ancit.cdt.astanalyzer.views;

import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTBinaryExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCompoundStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDeclarationStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTExpressionStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIfStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTLinkageSpecification;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTNamespaceDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTReturnStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTUsingDirective;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * This class provides the labels for the AST tree
 */
@SuppressWarnings("restriction")
public class CDTFileTreeLabelProvider implements ILabelProvider {

	private LocalResourceManager resourceManager;

	/**
	 * Gets the image to display for a node in the tree
	 * 
	 * @param arg0 the node
	 * @return Image
	 */
	@Override
	public Image getImage(Object node) {
		return null;
//		ImageDescriptor descriptor = null;
//		if (node instanceof IASTNode) {
//			descriptor = Activator.getImageDescriptor("/icons/arrow.png");
//		}
//
//		// obtain the cached image corresponding to the descriptor
//		Image image = descriptor.createImage();
//		return image;
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
		} else if (iastNode instanceof CPPASTCompoundStatement) {
			CPPASTCompoundStatement cppASTCompoundStatement = (CPPASTCompoundStatement) iastNode;
			text = cppASTCompoundStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTDeclarationStatement) {
			CPPASTDeclarationStatement cppASTDeclarationStatement = (CPPASTDeclarationStatement) iastNode;
			text = cppASTDeclarationStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTExpressionStatement) {
			CPPASTExpressionStatement cppASTExpressionStatement = (CPPASTExpressionStatement) iastNode;
			text = cppASTExpressionStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTIfStatement) {
			CPPASTIfStatement ifStatement = (CPPASTIfStatement) iastNode;
			text = ifStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTBinaryExpression) {
			CPPASTBinaryExpression binaryExpression = (CPPASTBinaryExpression) iastNode;
			text = binaryExpression.getRawSignature();
		} else if (iastNode instanceof CPPASTReturnStatement) {
			CPPASTReturnStatement cppASTReturnStatement = (CPPASTReturnStatement) iastNode;
			text = cppASTReturnStatement.getRawSignature();
		} else if (iastNode instanceof CPPASTNamespaceDefinition) {
			CPPASTNamespaceDefinition cppASTNamespaceDefinition = (CPPASTNamespaceDefinition) iastNode;
			text = cppASTNamespaceDefinition.getRawSignature();
		} else if (iastNode instanceof CPPASTUsingDirective) {
			CPPASTUsingDirective cppASTUsingDirective = (CPPASTUsingDirective) iastNode;
			text = cppASTUsingDirective.getRawSignature();
		} else if (iastNode instanceof CPPASTLinkageSpecification) {
			CPPASTLinkageSpecification cppASTLinkageSpecification = (CPPASTLinkageSpecification) iastNode;
			text = cppASTLinkageSpecification.getRawSignature();
		} else if (iastNode instanceof CPPASTSimpleDeclaration) {
			CPPASTSimpleDeclaration cppASTSimpleDeclaration = (CPPASTSimpleDeclaration) iastNode;
			text = cppASTSimpleDeclaration.getRawSignature();
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