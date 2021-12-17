package org.ancit.cdt.astanalyzer.views;


import javax.inject.Inject;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTBinaryExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIfStatement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

@SuppressWarnings("restriction")
public class CDTAbstractSyntaxTreeView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.ancit.cdt.astanalyzer.views.SampleView";

	@Inject IWorkbench workbench;
	
	private TreeViewer viewer;
	 

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
	    viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
	    viewer.setContentProvider(new CDTFileTreeContentProvider());
	    viewer.setLabelProvider(new CDTFileTreeLabelProvider());
	 

//		getSite().setSelectionProvider(viewer);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(new ISelectionListener() {
			
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				// TODO Auto-generated method stub
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection sSelection = (IStructuredSelection) selection;
					System.out.println(sSelection.getFirstElement().getClass());
					System.out.println(sSelection.getFirstElement());
					if (sSelection.getFirstElement() instanceof ITranslationUnit) {
						ITranslationUnit project = (ITranslationUnit) sSelection.getFirstElement();
						try {
							IASTNode astNode = project.getAST();
//							printAST(astNode.getChildren());
							viewer.setInput(astNode); // pass a non-null that will be ignored
							viewer.refresh();
							
						} catch (CoreException e) {
							e.printStackTrace();
						}
					} 		
				}
			}
		});
	}


	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private void printAST(IASTNode[] children) throws CoreException {
		for (IASTNode iastNode : children) {
			System.out.println(iastNode);
			if (iastNode instanceof CPPASTFunctionDefinition) {
				CPPASTFunctionDefinition cppFunctionDefinition = (CPPASTFunctionDefinition) iastNode;
				printAST(cppFunctionDefinition.getChildren());
				printAST(cppFunctionDefinition.getBody().getChildren());
			} else if (iastNode instanceof CPPASTIfStatement) {
				CPPASTIfStatement ifStatement = (CPPASTIfStatement) iastNode;
				printAST(ifStatement.getChildren());
				
			} else if (iastNode instanceof CPPASTBinaryExpression) {
				CPPASTBinaryExpression binaryExpression = (CPPASTBinaryExpression)iastNode;
				printAST(binaryExpression.getChildren());
			}
		}
	}
}
