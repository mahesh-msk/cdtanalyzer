package org.ancit.cdt.astanalyzer.views;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTBinaryExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIfStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTNamespaceDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTTranslationUnit;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This class provides the content for the tree in FileTree
 */
public class CDTFileTreeContentProvider implements ITreeContentProvider {
	
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IASTNode) {
			return((IASTNode) parentElement).getChildren();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof IASTNode) {
			return((IASTNode) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IASTNode) {
		  return element == null ? false : ((IASTNode) element).getChildren().length > 0;
		}
		else if (element instanceof CPPASTFunctionDefinition) {
			return element == null ? false : ((CPPASTFunctionDefinition) element).getChildren().length > 0;
		}
		else if (element instanceof CPPASTNamespaceDefinition) {
			return element == null ? false : ((CPPASTNamespaceDefinition) element).getChildren().length > 0;
		}
		else if (element instanceof CPPASTIfStatement) {
			return element == null ? false : ((CPPASTIfStatement) element).getChildren().length > 0;
		} else if (element instanceof CPPASTBinaryExpression) {
			return element == null ? false : ((CPPASTBinaryExpression) element).getChildren().length > 0;
		}
		return false;
	}
	


  /**
   * Gets the root element(s) of the tree
   * 
   * @param arg0
   *            the input data
   * @return Object[]
   */
@Override
  public Object[] getElements(Object node) {
    // These are the root elements of the tree
    // We don't care what arg0 is, because we just want all
    // the root nodes in the file system
	if (node instanceof CPPASTTranslationUnit) {
		return((CPPASTTranslationUnit) node).getChildren();
	}
	else if (node instanceof IASTNode) {
		return((IASTNode) node).getChildren();
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
   * @param arg0
   *            the viewer
   * @param arg1
   *            the old input
   * @param arg2
   *            the new input
   */
  public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
    // Nothing to change
  }




}