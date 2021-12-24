package org.ancit.cdt.astanalyzer.views;

import org.eclipse.cdt.core.dom.ast.IASTNode;
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
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTTranslationUnit;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTUsingDirective;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This class provides the content for the tree in FileTree
 */
@SuppressWarnings("restriction")
public class CDTFileTreeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof CPPASTFunctionDefinition) {
			return ((CPPASTFunctionDefinition) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTCompoundStatement) {
			return ((CPPASTCompoundStatement) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTDeclarationStatement) {
			return ((CPPASTDeclarationStatement) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTExpressionStatement) {
			return ((CPPASTExpressionStatement) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTIfStatement) {
			return ((CPPASTIfStatement) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTBinaryExpression) {
			return ((CPPASTBinaryExpression) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTReturnStatement) {
			return ((CPPASTReturnStatement) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTUsingDirective) {
			return ((CPPASTUsingDirective) parentElement).getChildren();
		} else if (parentElement instanceof CPPASTNamespaceDefinition) {
			return ((CPPASTNamespaceDefinition) parentElement).getChildren();
		}else if (parentElement instanceof CPPASTLinkageSpecification) {
			return ((CPPASTLinkageSpecification) parentElement).getChildren();
		}else if (parentElement instanceof CPPASTSimpleDeclaration) {
			return ((CPPASTSimpleDeclaration) parentElement).getChildren();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof CPPASTFunctionDefinition) {
			return ((CPPASTFunctionDefinition) element).getParent();
		} else if (element instanceof CPPASTCompoundStatement) {
			return ((CPPASTCompoundStatement) element).getParent();
		} else if (element instanceof CPPASTDeclarationStatement) {
			return ((CPPASTDeclarationStatement) element).getParent();
		} else if (element instanceof CPPASTExpressionStatement) {
			return ((CPPASTExpressionStatement) element).getParent();
		} else if (element instanceof CPPASTIfStatement) {
			return ((CPPASTIfStatement) element).getParent();
		} else if (element instanceof CPPASTBinaryExpression) {
			return ((CPPASTBinaryExpression) element).getParent();
		} else if (element instanceof CPPASTReturnStatement) {
			return ((CPPASTReturnStatement) element).getParent();
		} else if (element instanceof CPPASTNamespaceDefinition) {
			return ((CPPASTNamespaceDefinition) element).getParent();
		} else if (element instanceof CPPASTUsingDirective) {
			return ((CPPASTUsingDirective) element).getParent();
		}else if (element instanceof CPPASTLinkageSpecification) {
			return ((CPPASTLinkageSpecification) element).getParent();
		}else if (element instanceof CPPASTSimpleDeclaration) {
			return ((CPPASTSimpleDeclaration) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof CPPASTFunctionDefinition) {
			return element == null ? false : ((CPPASTFunctionDefinition) element).getChildren().length > 0;
		} else if (element instanceof CPPASTCompoundStatement) {
			return element == null ? false : ((CPPASTCompoundStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTDeclarationStatement) {
			return element == null ? false : ((CPPASTDeclarationStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTExpressionStatement) {
			return element == null ? false : ((CPPASTExpressionStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTIfStatement) {
			return element == null ? false : ((CPPASTIfStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTBinaryExpression) {
			return element == null ? false : ((CPPASTBinaryExpression) element).getChildren().length > 0;
		} else if (element instanceof CPPASTReturnStatement) {
			return element == null ? false : ((CPPASTReturnStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTNamespaceDefinition) {
			return element == null ? false : ((CPPASTNamespaceDefinition) element).getChildren().length > 0;
		} else if (element instanceof CPPASTUsingDirective) {
			return element == null ? false : ((CPPASTUsingDirective) element).getChildren().length > 0;
		}
		else if (element instanceof CPPASTLinkageSpecification) {
			return element == null ? false : ((CPPASTLinkageSpecification) element).getChildren().length > 0;
		}
		else if (element instanceof CPPASTSimpleDeclaration) {
			return element == null ? false : ((CPPASTSimpleDeclaration) element).getChildren().length > 0;
		}
		return false;
	}

	/**
	 * Gets the root element(s) of the tree
	 * 
	 * @param arg0 the input data
	 * @return Object[]
	 */
	@Override
	public Object[] getElements(Object node) {
		// These are the root elements of the tree
		// We don't care what arg0 is, because we just want all
		// the root nodes in the file system
		if (node instanceof CPPASTTranslationUnit) {
			return ((CPPASTTranslationUnit) node).getChildren();
		} else if (node instanceof IASTNode) {
			return ((IASTNode) node).getChildren();
		}
		return null;
	}

	/**
	 * Disposes any created resources
	 */
	public void dispose() {
		// Nothing to dispose
	}

	/**
	 * Called when the input changes
	 * 
	 * @param arg0 the viewer
	 * @param arg1 the old input
	 * @param arg2 the new input
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// Nothing to change
	}

}